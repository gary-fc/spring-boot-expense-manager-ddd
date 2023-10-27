package com.garyfrancodev.ExpenseManagerApplication.use_cases.transfer.command;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import com.garyfrancodev.ExpenseManagerApplication.dtos.transfer.CreateTransferDto;
import com.garyfrancodev.ExpenseManagerApplication.use_cases.transfer.command.CreateTransferCommand;
import com.garyfrancodev.ExpenseManagerDomain.events.transfer.CreatedTransfer;
import com.garyfrancodev.ExpenseManagerDomain.model.Account;
import com.garyfrancodev.ExpenseManagerDomain.model.Transfer;
import com.garyfrancodev.ExpenseManagerDomain.repositories.AccountRepository;
import com.garyfrancodev.ExpenseManagerDomain.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateTransferHandler implements Command.Handler<CreateTransferCommand, ResponseEntity<UUID>> {
    @Autowired
    private Pipeline pipeline;
    private final TransferRepository _transferRepository;
    public CreateTransferHandler(TransferRepository transferRepository) {
        this._transferRepository = transferRepository;
    }

    @Override
    public ResponseEntity<UUID> handle(CreateTransferCommand createTransferCommand) {
        CreateTransferDto createTransferDto = createTransferCommand.getCreateTransferDto();
        Transfer transfer = new Transfer(createTransferDto.getAccountSend(), createTransferDto.getAccountReceives(), createTransferDto.getAmount(), createTransferDto.getDate(), createTransferDto.getUserId());
        _transferRepository.create(transfer);

        new CreatedTransfer(transfer.getDate(),createTransferDto.getAccountSend(), createTransferDto.getAccountReceives(), createTransferDto.getAmount(), createTransferDto.getUserId(), "TODO", UUID.randomUUID()).send(pipeline);

        return ResponseEntity.ok(transfer.getId());
    }
}
