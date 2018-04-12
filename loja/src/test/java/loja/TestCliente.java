package loja;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Date;

import org.junit.Test;

import br.unibh.loja.entidades.Cliente;

public class TestCliente {
	
	@Test
	public void testCreateObject() {
		Cliente c = new Cliente(1L, "Gabriel", "garbel", "senha", "garbelg", "11111111111", "11 1 11111111",
				"gabriel@hotmail.com", new Date(), new Date());

		assertEquals(c.getId(), new Long(1));
		assertEquals(c.getNome(), "Gabriel");
		assertEquals(c.getLogin(), "garbel");
		assertEquals(c.getSenha(), "senha");
		assertEquals(c.getPerfil(), "garbelg");
		assertEquals(c.getCpf(), "11111111111");
		assertEquals(c.getTelefone(), "11 1 11111111");
		assertEquals(c.getEmail(), "gabriel@hotmail.com");
		assertEquals(c.getDataNascimento(), new Date());
		assertEquals(c.getDataCadastro(), new Date());

	}

	@Test
	public void testCompareObjects() {
		Date d = new Date();
		Cliente c1 = new Cliente(1L, "Gabriel", "garbel", "senha", "garbelg", "11111111111", "11 1 11111111",
				"gabriel@hotmail.com", d, d);
		Cliente c2 = new Cliente(1L, "Gabrielll", "garbel", "senha", "garbelg", "11111111111", "11 1 11111111",
				"gabriel@hotmail.com", d, d);
		assertNotEquals(c1, c2);
	}

	@Test
	public void testGenerateHash() {
		Date d = new Date();
		Cliente c1 = new Cliente(1L, "Gabriel", "garbel", "senha", "garbelg", "11111111111", "11 1 11111111",
				"gabriel@hotmail.com", d, d);
		Cliente c2 = new Cliente(1L, "Gabriel", "garbel", "senha", "garbelg", "11111111111", "11 1 11111111",
				"gabriel@hotmail.com", d, d);
		assertEquals(c1.hashCode(), c2.hashCode());
		Cliente c3 = new Cliente(1L, "Gabrielzinho", "garbel", "senha", "garbelg", "11111111111", "11 1 11111111",
				"gabriel@hotmail.com", d, d);
		assertNotEquals(c1.hashCode(), c3.hashCode());
	}

	public void testPrintObject() {
		Date d = new Date();
		Cliente c1 = new Cliente(1L, "Gabriel", "garbel", "senha", "garbelg", "11111111111", "11 1 11111111",
				"gabriel@hotmail.com", d, d);
		assertEquals(c1.toString(),
				"Cliente [id= 1L, nome=Gabriel, login=garbel, senha=senha, perfil=garbelg, cpf=11111111111, telefone=11 1 11111111, email=gabriel@hotmail.com, dataNascimento=new Date(), dataCadastro=new Date()");
	}
}
