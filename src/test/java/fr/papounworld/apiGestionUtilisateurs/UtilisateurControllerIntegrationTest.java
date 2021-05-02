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
public class UtilisateurControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	// $[0] car c'est un tableau
	@Test
	public void given_mockMvc_when_getUtilisateur1_then_loginIsNPAPON() {

		try {
			mockMvc.perform(get("/utilisateur")).andExpect(status().isOk())
					.andExpect(jsonPath("$[0].login", is("test")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
