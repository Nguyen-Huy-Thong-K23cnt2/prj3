package NhtK23cnt2.prj3.controller.admin;

import NhtK23cnt2.prj3.entity.product.NhtCategory;
import NhtK23cnt2.prj3.entity.product.NhtProduct;
import NhtK23cnt2.prj3.entity.user.NhtUser;
import NhtK23cnt2.prj3.entity.user.NhtUserRole;
import NhtK23cnt2.prj3.repository.product.NhtCategoryRepository;
import NhtK23cnt2.prj3.repository.product.NhtProductRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/admin/products")
@RequiredArgsConstructor
public class NhtAdminProductController {

    private final NhtProductRepository productRepository;
    private final NhtCategoryRepository categoryRepository;

    private final String uploadDir = "D:/prj3/project3/uploads/product-images";


    private boolean isAdmin(HttpSession session) {
        NhtUser currentUser = (NhtUser) session.getAttribute("currentUser");
        return currentUser != null && currentUser.getRole() == NhtUserRole.ADMIN;
    }

    @GetMapping
    public String listProducts(HttpSession session, Model model) {
        if (!isAdmin(session)) {
            return "redirect:/login";
        }

        List<NhtProduct> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "admin/NhtProductList";   // view list sản phẩm
    }


    @GetMapping("/create")
    public String showCreateForm(HttpSession session, Model model) {
        if (!isAdmin(session)) {
            return "redirect:/login";
        }

        NhtProduct product = new NhtProduct();
        List<NhtCategory> categories = categoryRepository.findAll();

        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        model.addAttribute("formMode", "CREATE");

        return "admin/NhtProductForm";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute("product") NhtProduct product,
                                @RequestParam("imageFile") MultipartFile imageFile,
                                HttpSession session,
                                Model model) {
        if (!isAdmin(session)) {
            return "redirect:/login";
        }

        if (imageFile != null && !imageFile.isEmpty()) {
            try {
                String fileName = saveImage(imageFile);
                product.setImage(fileName);
            } catch (IOException e) {
                model.addAttribute("error", "Upload ảnh thất bại, vui lòng thử lại!");
                model.addAttribute("categories", categoryRepository.findAll());
                model.addAttribute("formMode", "CREATE");
                return "admin/NhtProductForm";
            }
        }

        productRepository.save(product);
        return "redirect:/admin/products?created";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id,
                               HttpSession session,
                               Model model) {
        if (!isAdmin(session)) {
            return "redirect:/login";
        }

        NhtProduct product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        List<NhtCategory> categories = categoryRepository.findAll();

        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        model.addAttribute("formMode", "EDIT");

        return "admin/NhtProductForm";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("product") NhtProduct formProduct,
                                @RequestParam("imageFile") MultipartFile imageFile,
                                HttpSession session,
                                Model model) {
        if (!isAdmin(session)) {
            return "redirect:/login";
        }

        NhtProduct product = productRepository.findById(formProduct.getId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        product.setName(formProduct.getName());
        product.setPrice(formProduct.getPrice());
        product.setDescription(formProduct.getDescription());
        product.setCategory(formProduct.getCategory());
        product.setTag(formProduct.getTag());

        if (imageFile != null && !imageFile.isEmpty()) {
            try {
                String fileName = saveImage(imageFile);
                product.setImage(fileName);
            } catch (IOException e) {
                model.addAttribute("error", "Upload ảnh thất bại, vui lòng thử lại!");
                model.addAttribute("categories", categoryRepository.findAll());
                model.addAttribute("formMode", "EDIT");
                model.addAttribute("product", formProduct);
                return "admin/NhtProductForm";
            }
        }

        productRepository.save(product);
        return "redirect:/admin/products?updated";
    }


    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id,
                                HttpSession session) {
        if (!isAdmin(session)) {
            return "redirect:/login";
        }

        productRepository.deleteById(id);
        return "redirect:/admin/products?deleted";
    }

    private String saveImage(MultipartFile imageFile) throws IOException {
        String originalName = StringUtils.cleanPath(imageFile.getOriginalFilename());
        String ext = "";

        int dotIndex = originalName.lastIndexOf('.');
        if (dotIndex >= 0) {
            ext = originalName.substring(dotIndex);
        }

        String fileName = System.currentTimeMillis() + ext;

        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(fileName);
        imageFile.transferTo(filePath.toFile());

        return fileName;
    }
}
