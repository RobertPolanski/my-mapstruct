package de.it4ipm.mymapstruct.mapper;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import de.it4ipm.mymapstruct.dto.TransactionDTO;
import de.it4ipm.mymapstruct.entity.Transaction;
import org.mapstruct.Mapper;


@Mapper
abstract class TransactionMapper {

    public TransactionDTO toTransactionDTO(Transaction transaction) {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setUuid(transaction.getUuid());
        transactionDTO.setTotalInCents(transaction.getTotal().multiply(new BigDecimal("100")).longValue());
        return transactionDTO;
    }

    public abstract List<TransactionDTO> toTransactionDTO(Collection<Transaction> transactions);
}
