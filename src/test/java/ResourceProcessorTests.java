import de.wilms.springtest.ResourceProcessorApplication;
import de.wilms.springtest.entities.Citizen;
import de.wilms.springtest.processors.CitizenResourceProcessor;
import de.wilms.springtest.processors.CitizenResourcesProcessor;
import de.wilms.springtest.processors.ResourceSupportResourceProcessor;
import de.wilms.springtest.repositories.CitizenRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ResourceProcessorApplication.class)
@WebAppConfiguration
public class ResourceProcessorTests {

    @Autowired
    private CitizenRepository citizenRepository;

    @Autowired
    WebApplicationContext context;

    private MockMvc mockMvc;

    private UUID citizen1UID;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        Citizen citizen1 = new Citizen();
        citizen1UID = citizenRepository.save(citizen1).getOid();

        Citizen citizen2 = new Citizen();
        citizenRepository.save(citizen2);

        Citizen citizen3 = new Citizen();
        citizenRepository.save(citizen3);

        CitizenResourceProcessor.GOT_CALLED = false;
        CitizenResourcesProcessor.GOT_CALLED = false;
        ResourceSupportResourceProcessor.GOT_CALLED = false;
    }

    @After
    public void destroy(){
        citizenRepository.deleteAll();
        CitizenResourceProcessor.GOT_CALLED = false;
        CitizenResourcesProcessor.GOT_CALLED = false;
        ResourceSupportResourceProcessor.GOT_CALLED = false;
    }

    @Test
    public void testDataAvailable(){
        assertEquals(3, citizenRepository.count());
    }

    @Test
    public void readSingleTest() throws Exception {
        String urlTemplate = "/citizens/" + citizen1UID.toString();
        mockMvc.perform(get(urlTemplate))
                .andExpect(status().isOk());

        assertTrue(CitizenResourceProcessor.GOT_CALLED);
        assertFalse(CitizenResourcesProcessor.GOT_CALLED);
        assertTrue(ResourceSupportResourceProcessor.GOT_CALLED);
    }

    @Test
    public void readListTest() throws Exception {
        String urlTemplate = "/citizens/";
        mockMvc.perform(get(urlTemplate))
                .andExpect(status().isOk());

        assertFalse(CitizenResourceProcessor.GOT_CALLED);
        assertTrue(CitizenResourcesProcessor.GOT_CALLED);
        assertTrue(ResourceSupportResourceProcessor.GOT_CALLED);
    }

}
