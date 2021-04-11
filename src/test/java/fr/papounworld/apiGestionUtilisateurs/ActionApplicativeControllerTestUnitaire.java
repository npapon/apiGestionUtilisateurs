package fr.papounworld.apiGestionUtilisateurs;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import fr.papounworld.apiGestionUtilisateurs.service.ActionApplicativeService;
import fr.papounworld.apiGestionUtilisateurs.service.ActionUtilisateurService;
import fr.papounworld.apiGestionUtilisateurs.service.ConnexionUtilisateurService;
import fr.papounworld.apiGestionUtilisateurs.service.InformationPersonnelleUtilisateurService;
import fr.papounworld.apiGestionUtilisateurs.service.RoleService;
import fr.papounworld.apiGestionUtilisateurs.service.UtilisateurService;

@WebMvcTest(controllers = ActionApplicativeController.class)
public class ActionApplicativeControllerTestUnitaire {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ActionApplicativeService actionApplicativeService;

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

	@Test
	public void given_actionApplicativeService_when_getUrl_then_statutIsOk() throws Exception {

		mockMvc.perform(get("/actionapplicative")).andExpect(status().isOk());
	}

	@Test
	public void createItem() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/items").accept(MediaType.APPLICATION_JSON)
				.content("{\"id\":1,\"name\":\"Book\",\"price\":10,\"quantity\":100}")
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
	}

}
