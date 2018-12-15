package directory;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("testunit");
        EntityManager manager = factory.createEntityManager();

//        create(manager, "msg1");
//        create(manager, "msg2");
//        create(manager, "msg3");
//        create(manager, "msg4");
//        create(manager, "msg5");

        readAll(manager);

        Data dataToUpdate = readOne(manager, 50);
        update(manager,dataToUpdate,"New Message");

        //Data dataToDelete = readOne(manager,52);
        //delete(manager, dataToDelete);

        readAll(manager);


        System.exit(0);

    }

    public static void create(EntityManager manager, String msg){
        Data data = new Data(msg);
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(data);
        transaction.commit();
    }

    public static void readAll(EntityManager manager){
        TypedQuery<Data> dataQuery = manager.createQuery("SELECT d from Data d", Data.class);
        List<Data> dataList = dataQuery.getResultList();
        for(Data d : dataList){
            System.out.println(d);
        }
    }

    public static Data readOne(EntityManager manager, long id){

        TypedQuery<Data> dataQuery = manager.createQuery("SELECT d FROM Data d Where d.id = :id", Data.class);
        dataQuery.setParameter("id", id);
        Data foundData = dataQuery.getSingleResult();

//        TypedQuery<Data> asdasd = manager.createNamedQuery("Data.findById",Data.class).setParameter(
//                "id", new Long(2));
//        Data foundData = asdasd.getSingleResult();

        System.out.println("znaleziono: " + foundData);
        return foundData;
    }

    public static void update(EntityManager manager, Data data, String newMsg){

        manager.getTransaction().begin();
        data.setMsg(newMsg);
        manager.persist(data);
        manager.getTransaction().commit();
    }

    public static void delete(EntityManager manager, Data data){
        manager.getTransaction().begin();
        manager.remove(data);
        manager.getTransaction().commit();

        // manager.createQuery("DELETE from Data d WHERE id='2'", Data.class);
    }
}
