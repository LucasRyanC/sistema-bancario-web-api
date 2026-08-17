package com.lucasryan.sistemabancarioweb.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import java.util.Optional;
import com.lucasryan.sistemabancarioweb.model.Conta;
import com.lucasryan.sistemabancarioweb.repository.ContaRepository;

@ExtendWith(MockitoExtension.class)
public class ContaServiceTest {
    @Mock
    private ContaRepository repository;
    
    @InjectMocks
    private ContaService service;

    @Test
    public void deveLancarErroQuandoDepositoForNegativoOuZero() {
        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> {
            service.depositar(1L, -50.0);
        });

        assertEquals("Erro: O valor do depósito deve ser maior que zero.", erro.getMessage());
    }

    @Test
    public void deveRealizarDepositoComSucesso() {
        Conta contaFalsa = new Conta();
        contaFalsa.setId(1L);
        contaFalsa.setTitular("Lucas");
        contaFalsa.setSaldo(1000.0);

        when(repository.findById(1L)).thenReturn(Optional.of(contaFalsa));

        when(repository.save(any(Conta.class))).thenReturn(contaFalsa);

        Conta contaAtualizada = service.depositar(1L, 500.0);

        assertEquals(1500.0, contaAtualizada.getSaldo());
    }

    @Test
    public void deveLancarErroQuandoSaqueForNegativoOuZero() {
        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> {
            service.sacar(1L, -100.0);
        });

        assertEquals("Erro: O valor do saque deve ser maior que zero.", erro.getMessage());
    }
    
    @Test
    public void deveLancarErroQuandoSaldoForInsuficiente() {
        Conta contaPobre = new Conta();
        contaPobre.setId(1L);
        contaPobre.setSaldo(100.0);

        when(repository.findById(1L)).thenReturn(Optional.of(contaPobre));

        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> {
            service.sacar(1L, 500.0);
        });

        assertEquals("Erro: Saldo insuficiente para este saque.", erro.getMessage());
    }

    @Test
    public void deveRealizarSaqueComSucesso() {
        Conta contaRica = new Conta();
        contaRica.setId(1L);
        contaRica.setSaldo(1000.0);

        when(repository.findById(1L)).thenReturn(Optional.of(contaRica));
        when(repository.save(any(Conta.class))).thenReturn(contaRica);

        Conta contaAtualizada = service.sacar(1L, 300.0);
        assertEquals(700.0, contaAtualizada.getSaldo());
    }
}
