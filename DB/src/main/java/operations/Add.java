//package operations;
//
//import jakarta.persistence.EntityManager;
//
//public class Add extends DatabaseManager{
//
//    public Add(EntityManager entityManager) {
//        super(entityManager);
//    }
//
//    @Override
//    public <T> void addToDatabase(T entity) {
//        entityManager.getTransaction().begin();
//        entityManager.persist(entity);
//        entityManager.getTransaction().commit();
//    }
//}
