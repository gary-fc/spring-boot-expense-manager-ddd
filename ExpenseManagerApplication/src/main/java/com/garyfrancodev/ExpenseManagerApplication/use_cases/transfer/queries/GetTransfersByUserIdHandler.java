package com.garyfrancodev.ExpenseManagerApplication.use_cases.transfer.queries;

import an.awesome.pipelinr.Command;
import com.garyfrancodev.ExpenseManagerApplication.dtos.transfer.TransferDto;
import com.garyfrancodev.ExpenseManagerDomain.model.Transfer;
import com.garyfrancodev.ExpenseManagerDomain.repositories.TransferRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetTransfersByUserIdHandler implements Command.Handler<GetTransfersByUserIdQuery, ResponseEntity<List<TransferDto>>> {

    private final TransferRepository _transferRepository;

    public GetTransfersByUserIdHandler(TransferRepository transferRepository) {
        this._transferRepository = transferRepository;
    }

    @Override
    public ResponseEntity<List<TransferDto>> handle(GetTransfersByUserIdQuery getTransfersByUserIdQuery) {
        List<Transfer> transferList = _transferRepository.transferListByUserId(getTransfersByUserIdQuery.getUserId());

        return ResponseEntity.ok(transferList.stream().map(transfer -> new TransferDto(transfer.getId(), transfer.getAccountSend(), transfer.getAccountReceives(), transfer.getAmount(), transfer.getDate(), transfer.getUserId())).toList());
    }
}
