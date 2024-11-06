package com.tuaev.delivery_service.services;

import com.tuaev.delivery_service.Comments;
import com.tuaev.delivery_service.document.Status;
import com.tuaev.delivery_service.repositories.StatusRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class DefaultStatusService implements StatusService{

    private StatusRepo statusRepo;

    @Override
    public Status save(Long orderId) {
        return statusRepo.save(create(orderId));
    }

    @Override
    public Status update(Long orderId, String comments) {
        Status status = statusRepo.findByOrderId(orderId);
        List<String> statuses = Comments.getAllStatuses();
        checkStatus(comments, status, statuses);
        status.setDateTime(LocalDateTime.now());
        statusRepo.save(status);
        return status;
    }

    private void checkStatus(String comments, Status status, List<String> statuses) {
        if (statuses.stream().anyMatch(comment ->
                comment.equals(comments))){
            status.setComments(comments);
        }
    }

    private Status create(Long orderId){
        return new Status(
                orderId,
                Comments.GENERATED.getStatus(),
                LocalDateTime.now().plusHours(3)
        );
    }
}
