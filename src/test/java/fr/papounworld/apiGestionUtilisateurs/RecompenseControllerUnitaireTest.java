package fr.papounworld.apiGestionUtilisateurs;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import fr.papounworld.apiGestionUtilisateurs.controller.RecompenseController;
import fr.papounworld.apiGestionUtilisateurs.service.ActionApplicativeService;
import fr.papounworld.apiGestionUtilisateurs.service.ConnexionUtilisateurService;
import fr.papounworld.apiGestionUtilisateurs.service.RecompenseService;
import fr.papounworld.apiGestionUtilisateurs.service.UtilisateurService;

@WebMvcTest({ RecompenseController.class })
public class RecompenseControllerUnitaireTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UtilisateurService utilisateurService;

	@MockBean
	private ActionApplicativeService actionApplicativeService;

	@MockBean
	private RecompenseService recompenseService;

	@MockBean
	private ConnexionUtilisateurService connexionUtilisateurService;

	@BeforeEach
	public void init() {
		System.out.println(LocalDate.now());

	}

	@Test
	public void given_recompense_when_get_then_statutIsOk() throws Exception {

		mockMvc.perform(get("/recompense")).andExpect(status().isOk());
	}

	@Test
	public void given_recompense_when_post_then_statutIsOk() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
				.post("/recompense").accept(MediaType.APPLICATION_JSON).content(" {\r\n" + "        \"id\": 1,\r\n"
						+ "        \"libelle\": \"première connexion\"\r\n" + "    }")
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
	}

	@Test
	public void given_recompense_when_put_then_statutIsOk() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
				.put("/recompense/{id}", 1).accept(MediaType.APPLICATION_JSON).content(" {\r\n"
						+ "        \"id\": 1,\r\n" + "        \"libelle\": \"première connexion\"\r\n" + "    }")
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
	}

	@Test
	public void given_recompense_when_delete_then_statutIsOk() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.delete("/recompense/{id}", 1);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
	}

}
