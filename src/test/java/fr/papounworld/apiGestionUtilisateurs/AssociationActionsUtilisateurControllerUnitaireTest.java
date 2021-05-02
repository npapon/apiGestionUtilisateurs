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

import fr.papounworld.apiGestionUtilisateurs.controller.AssociationActionsUtilisateurController;
import fr.papounworld.apiGestionUtilisateurs.service.ActionApplicativeService;
import fr.papounworld.apiGestionUtilisateurs.service.ActionUtilisateurService;
import fr.papounworld.apiGestionUtilisateurs.service.AssociationActionsUtilisateurService;
import fr.papounworld.apiGestionUtilisateurs.service.ConnexionUtilisateurService;
import fr.papounworld.apiGestionUtilisateurs.service.InformationPersonnelleUtilisateurService;
import fr.papounworld.apiGestionUtilisateurs.service.RoleService;
import fr.papounworld.apiGestionUtilisateurs.service.UtilisateurService;

@WebMvcTest({ AssociationActionsUtilisateurController.class })
public class AssociationActionsUtilisateurControllerUnitaireTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AssociationActionsUtilisateurService associationActionsUtilisateurService;

	@MockBean
	private UtilisateurService utilisateurService;

	@MockBean
	private ActionApplicativeService actionApplicativeService;

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
	public void given_associationActionsUtilisateur_when_get_then_statutIsOk() throws Exception {

		mockMvc.perform(get("/associationactionsutilisateur")).andExpect(status().isOk());
	}

	@Test
	public void given_associationActionsUtilisateur_when_post_then_statutIsOk() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/associationactionsutilisateur")
				.accept(MediaType.APPLICATION_JSON).content("   {\r\n" + "        \"id\": 9,\r\n"
						+ "        \"idAction\": 8,\r\n" + "        \"idUtilisateur\": 2\r\n" + "    }")
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
	}

	@Test
	public void given_associationActionsUtilisateur_when_put_then_statutIsOk() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.put("/associationactionsutilisateur/{id}", 9)
				.accept(MediaType.APPLICATION_JSON).content("   {\r\n" + "        \"id\": 9,\r\n"
						+ "        \"idAction\": 8,\r\n" + "        \"idUtilisateur\": 2\r\n" + "    }")
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
	}

	@Test
	public void given_associationActionsUtilisateur_when_delete_then_statutIsOk() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.delete("/associationactionsutilisateur/{id}", 9);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
	}

}
