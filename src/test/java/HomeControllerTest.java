import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import spittr.Spittle;
import spittr.data.SpittleRespository;
import spittr.web.HomeController;
import spittr.web.SpittleController;

import java.util.List;

import static org.junit.matchers.JUnitMatchers.hasItems;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

public class HomeControllerTest {
    @Test
    public void testHomePage() throws Exception {
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"));
        //assertEquals("home",controller.home());

    }

    @Test
    public void shouldShowPagedSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(50);
        SpittleRespository mockRespository = mock(SpittleRespository.class);
        when(mockRespository.findSpittles(2389000, 50)).thenReturn(expectedSpittles);

        SpittleController controller =
                new SpittleController(mockRespository);
        MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView(
                "/WEB-INF/views/spittle.jsp"
        )).build();
        mockMvc.perform(get("/spittles?max=238900&count=50"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittlesList", hasItems(expectedSpittles.toArray())));
    }
}
