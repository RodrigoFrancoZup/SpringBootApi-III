package br.com.alura.forum.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.alura.forum.modelo.Curso;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class CursoRepositoryTest {

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private TestEntityManager em;

	@Test
	public void deveriaCarregarUmCursoAoBuscarPeloSeuNome() {
		Curso curso = new Curso();
		curso.setNome("HTML 5");
		curso.setCategoria("Programacao");
		em.persist(curso);

		String nomeCurso = "HTML 5";
		Curso cursoEncontado = cursoRepository.findByNome(nomeCurso);
		Assert.assertNotNull(cursoEncontado);
		Assert.assertEquals(nomeCurso, cursoEncontado.getNome());
	}

	@Test
	public void deveRetonarNullComAoRealizarBuscaComNomeDeCursoQueNaoExiste() {
		String nomeCurso = "NÃO EXISTE";
		Curso curso = cursoRepository.findByNome(nomeCurso);
		Assert.assertNull(curso);
	}
}
