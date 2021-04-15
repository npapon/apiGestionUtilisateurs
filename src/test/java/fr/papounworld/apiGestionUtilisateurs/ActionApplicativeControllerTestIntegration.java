package fr.papounworld.apiGestionUtilisateurs;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ActionApplicativeControllerTestIntegration {

	@Autowired
	private MockMvc mockMvc;

	// $[0] car c'est un tableau
	@Test
	public void given_mockMvc_when_ActionApplicative1_then_libelleIseffacerDoublonCommandeSap() {

		try {
			mockMvc.perform(get("/actionapplicative")).andExpect(status().isOk())
					.andExpect(jsonPath("$[0].libelle", is("effacer doublon commandes sap")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void given_mockMvc_when_ActionApplicativescript1_then_libelleIseffacerDoublonCommandeSap() {

		try {
			mockMvc.perform(get("/actionapplicativescript")).andExpect(status().isOk())
					.andExpect(jsonPath("$[0].libelle", is("effacer doublon commandes sap")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void given_mockMvc_when_ActionApplicativeextraction1_then_libelleIseffacerDoublonCommandeSap() {

		try {
			mockMvc.perform(get("/actionapplicativeextraction")).andExpect(status().isOk())
					.andExpect(jsonPath("$[0].libelle", is("extraction liste diffusions")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
