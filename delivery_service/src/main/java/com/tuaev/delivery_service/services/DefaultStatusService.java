package com.tuaev.delivery_service.services;

import com.tuaev.delivery_service.Comments;
import com.tuaev.delivery_service.document.Status;
import com.tuaev.delivery_service.dto.StatusDTO;
import com.tuaev.delivery_service.mapper.StatusMapper;
import com.tuaev.delivery_service.repositories.StatusRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class DefaultStatusService implements StatusService{

    private StatusRepo statusRepo;
    private StatusMapper statusMapper;

    @Override
    public StatusDTO save(Long orderId) {
        return statusMapper.toStatusDTO(statusRepo.save(create(orderId)));
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
            status.setDescription(comments);
        }
    }

    private Status create(Long orderId){
        return statusMapper.toStatus(orderId, Comments.GENERATED.getStatus(), LocalDateTime.now());
    }
}
