import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import ru.misha.implement.RoleStorage;
import ru.misha.interfaces.RoleDAO;
import ru.misha.model.Client;
import ru.misha.model.Role;

import java.util.Map;


public class Main {

    public static void main(String[] args) {
        Role role = new Role();
        role.setRole("Admin");

        RoleDAO roleDAO = new RoleStorage();
        roleDAO.create(role);
    }
}
