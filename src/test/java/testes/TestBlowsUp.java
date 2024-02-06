package testes;

import org.junit.Test;

import static org.junit.Assert.fail;

public class TestBlowsUp {

    @Test
    public void testBlowsUp() {
        try{
            blowsUp();
            //se a linha acima não lançar uma exceção, falha o teste
            fail("A exceção esperada não foi lançada.");
        } catch (RuntimeException e) {
            //verifica se a mensagem de exceção é correta;
            String mesagemEsperada = "Somebody should catch this!";
            assert mesagemEsperada.equals(e.getMessage()) : "Mensagem incorreta na exceção lançada.";
        }
    }

    //método privado que lança uma RuntimeException
    private void blowsUp() {
        throw new RuntimeException("Somebody should catch this!");
    }
}
