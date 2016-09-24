package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC02ConsultarEmpresa {

	static Empresa resultadoEsperado;
	static Empresa resultadoObtido;
	static EmpresaDAO empresaDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		resultadoEsperado = new Empresa();
		resultadoEsperado.setCnpj("87645558000102");
		resultadoEsperado.setNomeDaEmpresa("Jose Silva S/A");
		resultadoEsperado.setNomeFantasia("Casas Bahia");
		resultadoEsperado.setEndereco("Rua Taquari");
		resultadoEsperado.setTelefone("111111");

		empresaDAO = new EmpresaDAO();
		// empresaDAO.exclui("87645558000102");
		empresaDAO.adiciona(resultadoEsperado);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	@After
	public void excluiEmpresa() {
		empresaDAO.exclui("87645558000102");
	}

	/**
	 * verificar o comportamento do sistema na consulta de uma empresa com
	 * sucesso
	 */
	@Test
	public void CT01UC02FBConsultarEmpresa_com_sucesso() { // FB = Fluxo Básico

		resultadoObtido = empresaDAO.consulta("87645558000102");
		assertTrue(resultadoEsperado.equals(resultadoObtido));
	}

}
