package com.bindstone.graphbank.crud;

import com.bindstone.graphbank.domain.DomainObject;
import com.bindstone.graphbank.service.CrudService;
import com.bindstone.graphbank.service.DatabaseService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
@Transactional
public abstract class AbstractCrudTest<T extends DomainObject> {

    @Autowired
    private DatabaseService databaseService;

    @Before
    public void clearDB() {
        databaseService.clear();
    }

    @Test
    public void insert() {
        T addedClazz = getCrudService().insert(getTestClazz());
        assertNotNull("Object not returned by insert", addedClazz);
        assertNotNull("ID not set by insert", addedClazz.getId());
        assertFalse("Validate equals condition NULL", addedClazz.equals(null));
        assertFalse("Validate equals condition different classes", addedClazz.equals(new String()));
        assertTrue("Validate equals condition object=object", addedClazz.equals(addedClazz));
    }

    @Test
    public void update() {
        List<T> clazzes = getCrudService().findAll();
        assertNotNull("List should be generated", clazzes);
        assertEquals("List should be still empty", 0, clazzes.size());

        T addedClazz = getCrudService().save(getTestClazz());
        assertNotNull("Object not returned by insert", addedClazz);
        assertNotNull("ID not set by insert", addedClazz.getId());

        clazzes = getCrudService().findAll();
        assertNotNull("List should be generated", clazzes);
        assertEquals("List should be still contains 1 element", 1, clazzes.size());

        T updatedClazz = getCrudService().findById(addedClazz.getId());
        getCrudService().update(updatedClazz);
        updatedClazz = getCrudService().findById(addedClazz.getId());
        assertEquals("ID of objects is not equals", addedClazz.getId(), updatedClazz.getId());
        assertNotEquals("Versions must be different", addedClazz.getModified(), updatedClazz.getModified());

        T upsert = getCrudService().findById(addedClazz.getId());
        getCrudService().save(upsert);
        upsert = getCrudService().findById(addedClazz.getId());
        assertEquals("ID of objects is not equals", addedClazz.getId(), upsert.getId());
        assertNotEquals("Versions must be different", addedClazz.getModified(), upsert.getModified());

        clazzes = getCrudService().findAll();
        assertNotNull("List should be generated", clazzes);
        assertEquals("List should be still contains 1 element", 1, clazzes.size());
    }

    @Test
    public void saveList() {
        List<T> savedClazzes = getCrudService().save(getTestClazzes());
        assertNotNull("List should be generated", savedClazzes);
        assertNotEquals("List should be still empty", 0, savedClazzes.size());
        for (T clazz : savedClazzes) {
            assertNotNull("Object not returned by insert", clazz);
            assertNotNull("ID not set by insert", clazz.getId());
        }
    }

    @Test
    public void findAll() {
        List<T> clazzes = getCrudService().findAll();
        assertNotNull("List should be generated", clazzes);
        assertEquals("List should be still empty", 0, clazzes.size());
        getCrudService().insert(getTestClazz());
        clazzes = getCrudService().findAll();
        assertNotNull("List should be generated", clazzes);
        assertEquals("List should be filled", 1, clazzes.size());
    }

    @Test
    public void findById() {
        final T newClazz = getCrudService().insert(getTestClazz());
        final T findClazz = getCrudService().findById(newClazz.getId());
        assertEquals("Found item should be equals", newClazz, findClazz);
        assertEquals("Found item should be equals", newClazz.hashCode(), findClazz.hashCode());
    }

    @Test
    public void delete() {
        List<T> items = getCrudService().findAll();
        assertEquals("List should be still empty", 0, items.size());
        T newClazz = getCrudService().insert(getTestClazz());
        items = getCrudService().findAll();
        assertEquals("List should be filled", 1, items.size());
        getCrudService().delete(newClazz);
        items = getCrudService().findAll();
        assertEquals("List should be again empty", 0, items.size());
    }

    public abstract T getTestClazz();

    public abstract List<T> getTestClazzes();

    public abstract CrudService<T> getCrudService();
}
