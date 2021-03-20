package com.sigrid.tdd_bdd.validadorCpf;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import org.junit.jupiter.api.DisplayName;
import com.sigrid.tdd_bdd.validadorCpf.models.Cliente;


@SpringBootTest
class ValidadorCpfApplicationTests {

	@Test
	void fazendoTesteDeCpfValido() {
		Cliente cliente = new Cliente();
		cliente.setNome("Sigrid");
		cliente.setCpf("01852261080");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalido() {
		Cliente cliente = new Cliente();
		cliente.setNome("Sigrid");
		cliente.setCpf("01852261011");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfComDigitoAMenos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Sigrid");
		cliente.setCpf("01852261011");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfValidoComPontos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Sigrid");
		cliente.setCpf("018.522.610-80");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComPontos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Sigrid");
		cliente.setCpf("018.522.610-11");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfValidoComEspacoNoComeco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Sigrid");
		cliente.setCpf(" 018.522.610-80");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfValidoComEspacoNoFinal() {
		Cliente cliente = new Cliente();
		cliente.setNome("Sigrid");
		cliente.setCpf("018.522.610-80 ");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfValidoComEspacoNoMeio() {
		Cliente cliente = new Cliente();
		cliente.setNome("Sigrid");
		cliente.setCpf("018.522. 610-80");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComVirgula() {
		Cliente cliente = new Cliente();
		cliente.setNome("Sigrid");
		cliente.setCpf("018,522.610-10");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfValidoComCpfMalucoQuePassou() {
		Cliente cliente = new Cliente();
		cliente.setNome("Sigrid");
		cliente.setCpf("69b.969.790-88");
		assertEquals(false, cliente.validarCPF());
	}

}
