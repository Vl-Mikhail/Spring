package ru.misha.implement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.misha.interfaces.ImageDAO;
import ru.misha.model.Image;

import java.util.Collection;

@Repository
public class ImageStorage implements ImageDAO{

    private final HibernateTemplate template;

    @Autowired
    public ImageStorage(HibernateTemplate template) {
        this.template = template;
    }


    @Override
    public Collection<Image> getAll() {
        return (Collection<Image>) this.template.find("from Image");
    }

    @Override
    @Transactional
    public int create(Image image) {
        return (int) this.template.save(image);
    }

    @Override
    @Transactional
    public void update(Image image) {
        this.template.saveOrUpdate(image);
    }

    @Override
    @Transactional
    public void delete(int id) {
        this.template.delete(template.get(Image.class, id));
    }

    @Override
    public Collection<Image> getByName(String name) {
        return (Collection<Image>) this.template.find("from Image i where i.image = ?", name);
    }
}
