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

import fr.papounworld.apiGestionUtilisateurs.controller.FichierUtilisateurController;
import fr.papounworld.apiGestionUtilisateurs.service.ActionApplicativeService;
import fr.papounworld.apiGestionUtilisateurs.service.ConnexionUtilisateurService;
import fr.papounworld.apiGestionUtilisateurs.service.FichierUtilisateurService;
import fr.papounworld.apiGestionUtilisateurs.service.InformationPersonnelleUtilisateurService;
import fr.papounworld.apiGestionUtilisateurs.service.RoleService;
import fr.papounworld.apiGestionUtilisateurs.service.UtilisateurService;

@WebMvcTest({ FichierUtilisateurController.class })
public class FichierUtilisateurControllerTestUnitaire {

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

	@MockBean
	private FichierUtilisateurService fichierUtilisateurService;

	@BeforeEach
	public void init() {
		System.out.println(LocalDate.now());

	}

	@Test
	public void given_fichierUtilisateur_when_get_then_statutIsOk() throws Exception {

		mockMvc.perform(get("/fichierutilisateur")).andExpect(status().isOk());
	}

	@Test
	public void given_fichierUtilisateur_when_post_then_statutIsOk() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/fichierutilisateur").accept(MediaType.APPLICATION_JSON)
				.content("    {\r\n" + "  \r\n" + "        \"type\": \"image profil\",\r\n"
						+ "        \"emplacement\": \"/images/imagesProfil/lpochat.jpg\"\r\n" + "    }")
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
	}

	@Test
	public void given_fichierUtilisateur_when_put_then_statutIsOk() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.put("/fichierutilisateur/{id}", 1)
				.accept(MediaType.APPLICATION_JSON)
				.content("    {\r\n" + "  \r\n" + "        \"type\": \"image profil\",\r\n"
						+ "        \"emplacement\": \"/images/imagesProfil/lpochat.jpg\"\r\n" + "    }")
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
	}

	@Test
	public void given_fichierUtilisateur_when_delete_then_statutIsOk() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.delete("/fichierutilisateur/{id}", 1);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
	}

}
