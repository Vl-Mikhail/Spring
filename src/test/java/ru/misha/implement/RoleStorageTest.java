package ru.misha.implement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.misha.model.Role;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class RoleStorageTest {

//    ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
//    Storages storages = context.getBean(Storages.class);

    @Autowired
    Storages storages;

    @Test
    public void testGetAll() throws Exception {
        Role role = new Role();
        role.setRole("Admin5");
        int id = storages.roleDAO.create(role);
        assertThat(storages.roleDAO.getRoleById(id).getRole(), is(role.getRole()));
        assertNotNull(storages.roleDAO.getByName("Admin5"));
        storages.roleDAO.delete(id);

        System.out.println(storages.roleDAO.getAll());


    }
}