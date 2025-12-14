package NhtK23cnt2.prj3.service.product;

import NhtK23cnt2.prj3.entity.product.NhtProductComment;
import NhtK23cnt2.prj3.repository.product.NhtProductCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NhtProductCommentService {

    private final NhtProductCommentRepository commentRepository;

    public List<NhtProductComment> getByProduct(Long productId) {
        return commentRepository
                .findByProductIdOrderByCreatedAtDesc(productId);
    }

    public void save(NhtProductComment comment) {
        comment.setCreatedAt(LocalDateTime.now());
        commentRepository.save(comment);
    }
}
