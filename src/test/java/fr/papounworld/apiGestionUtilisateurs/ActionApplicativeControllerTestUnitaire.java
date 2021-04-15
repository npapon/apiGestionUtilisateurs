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

import fr.papounworld.apiGestionUtilisateurs.controller.ActionApplicativeController;
import fr.papounworld.apiGestionUtilisateurs.controller.ActionApplicativeExtractionController;
import fr.papounworld.apiGestionUtilisateurs.controller.ActionApplicativeScriptController;
import fr.papounworld.apiGestionUtilisateurs.service.ActionApplicativeExtractionService;
import fr.papounworld.apiGestionUtilisateurs.service.ActionApplicativeScriptService;
import fr.papounworld.apiGestionUtilisateurs.service.ActionApplicativeService;
import fr.papounworld.apiGestionUtilisateurs.service.ActionUtilisateurService;
import fr.papounworld.apiGestionUtilisateurs.service.ConnexionUtilisateurService;
import fr.papounworld.apiGestionUtilisateurs.service.InformationPersonnelleUtilisateurService;
import fr.papounworld.apiGestionUtilisateurs.service.RoleService;
import fr.papounworld.apiGestionUtilisateurs.service.UtilisateurService;

@WebMvcTest({ ActionApplicativeController.class, ActionApplicativeScriptController.class,
		ActionApplicativeExtractionController.class })
public class ActionApplicativeControllerTestUnitaire {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ActionApplicativeService actionApplicativeService;

	@MockBean
	private ActionApplicativeScriptService actionApplicativeScriptService;

	@MockBean
	private ActionApplicativeExtractionService actionApplicativeExtractionService;

	@MockBean
	private UtilisateurService utilisateurService;

	@MockBean
	private InformationPersonnelleUtilisateurService informationPersonelleUtilisateurService;

	@MockBean
	private RoleService roleService;

	@MockBean
	private ConnexionUtilisateurService connexionUtilisateurService;

	@MockBean
	private ActionUtilisateurService actionUtilisateurService;

	@BeforeEach
	public void init() {
		System.out.println(LocalDate.now());

	}

	@Test
	public void given_actionApplicativeService_when_get_then_statutIsOk() throws Exception {

		mockMvc.perform(get("/actionapplicative")).andExpect(status().isOk());
	}

	@Test
	public void given_actionApplicativeScriptService_when_get_then_statutIsOk() throws Exception {

		mockMvc.perform(get("/actionapplicativescript")).andExpect(status().isOk());
	}

	@Test
	public void given_actionApplicativeExtractionService_when_get_then_statutIsOk() throws Exception {

		mockMvc.perform(get("/actionapplicativeextraction")).andExpect(status().isOk());
	}

	@Test
	public void given_actionApplicativeExtractionService_when_post_then_statutIsOk() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/actionapplicativeextraction")
				.accept(MediaType.APPLICATION_JSON)
				.content("   {\r\n" + "        \r\n" + "        \"libelle\": \"quota diff\",\r\n"
						+ "        \"formatSortie\": \"ppt\"\r\n" + "    }")
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
	}

	@Test
	public void given_actionApplicativeScriptService_when_post_then_statutIsOk() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/actionapplicativescript")
				.accept(MediaType.APPLICATION_JSON).content("   {\r\n" + "        \r\n"
						+ "        \"libelle\": \"script lambda\",\r\n" + "        \"crud\": \"delete\"\r\n" + "    }")
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
	}

	@Test
	public void given_actionApplicativeExtractionService_when_put_then_statutIsOk() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.put("/actionapplicativeextraction/{id}", 2)
				.accept(MediaType.APPLICATION_JSON)
				.content("   {\r\n" + "        \r\n" + "        \"libelle\": \"quota diff\",\r\n"
						+ "        \"formatSortie\": \"ppt\"\r\n" + "    }")
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
	}

	@Test
	public void given_actionApplicativeScript_when_put_then_statutIsOk() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.put("/actionapplicativescript/{id}", 2)
				.accept(MediaType.APPLICATION_JSON).content("   {\r\n" + "        \r\n"
						+ "        \"libelle\": \"script lambda\",\r\n" + "        \"crud\": \"update\"\r\n" + "    }")
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
	}

	@Test
	public void given_actionApplicativeExtraction_when_delete_then_statutIsOk() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.delete("/actionapplicativeextraction/{id}", 1);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
	}

	@Test
	public void given_actionApplicativeScript_when_delete_then_statutIsOk() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.delete("/actionapplicativescript/{id}", 1);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
	}

}
