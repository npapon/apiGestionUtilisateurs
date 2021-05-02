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

import fr.papounworld.apiGestionUtilisateurs.controller.ConnexionUtilisateurController;
import fr.papounworld.apiGestionUtilisateurs.service.ActionApplicativeService;
import fr.papounworld.apiGestionUtilisateurs.service.ConnexionUtilisateurService;
import fr.papounworld.apiGestionUtilisateurs.service.InformationPersonnelleUtilisateurService;
import fr.papounworld.apiGestionUtilisateurs.service.RoleService;
import fr.papounworld.apiGestionUtilisateurs.service.UtilisateurService;

@WebMvcTest({ ConnexionUtilisateurController.class })
public class ConnexionUtilisateurControllerUnitaireTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UtilisateurService utilisateurService;

	@MockBean
	private InformationPersonnelleUtilisateurService informationPersonelleUtilisateurService;

	@MockBean
	private RoleService roleService;

	@MockBean
	private ConnexionUtilisateurService connexionUtilisateurService;

	@MockBean
	private ActionApplicativeService actionApplicativeService;

	@BeforeEach
	public void init() {
		System.out.println(LocalDate.now());

	}

	@Test
	public void given_connexionUtilisateur_when_get_then_statutIsOk() throws Exception {

		mockMvc.perform(get("/connexionutilisateur")).andExpect(status().isOk());
	}

	@Test
	public void given_connexionUtilisateur_when_post_then_statutIsOk() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/connexionutilisateur").accept(MediaType.APPLICATION_JSON)
				.content("{\r\n" + "    \"id\": 1,\r\n" + "    \"utilisateur\": {\r\n" + "        \"id\": 63\r\n"
						+ "    },\r\n" + "    \"connexionDate\": \"2021-03-24T17:45:10.000+00:00\"\r\n" + "}")
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
	}

	@Test
	public void given_connexionUtilisateur_when_put_then_statutIsOk() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.put("/connexionutilisateur/{id}", 21)
				.accept(MediaType.APPLICATION_JSON)
				.content("{\r\n" + "    \"id\": 1,\r\n" + "    \"utilisateur\": {\r\n" + "        \"id\": 63\r\n"
						+ "    },\r\n" + "    \"connexionDate\": \"2021-03-24T17:45:10.000+00:00\"\r\n" + "}")
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
	}

	@Test
	public void given_connexionUtilisateur_when_delete_then_statutIsOk() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.delete("/connexionutilisateur/{id}", 21);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
	}

}
