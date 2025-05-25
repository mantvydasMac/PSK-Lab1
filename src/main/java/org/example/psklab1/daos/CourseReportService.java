package org.example.psklab1.daos;
import jakarta.ejb.Asynchronous;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.psklab1.dtos.CourseEnrollmentDTO;

import java.util.List;

@Stateless
public class CourseReportService {

    @PersistenceContext
    private EntityManager em;

    @Asynchronous
    public void generateEnrollmentReport() {
        System.out.println("-|-----------|- Started course report calculation -|-----------|-");
        try {
            Thread.sleep(5000);

            List<CourseEnrollmentDTO> report = em.createQuery(
                    "SELECT new org.example.psklab1.dtos.CourseEnrollmentDTO(c.id, c.title, COUNT(cs)) " +
                            "FROM Course c LEFT JOIN c.students cs " +
                            "GROUP BY c.id, c.title " +
                            "ORDER BY c.id", CourseEnrollmentDTO.class
            ).getResultList();

            System.out.println("-|-----------|- Finished course report calculation -|-----------|-");
            for (CourseEnrollmentDTO row : report) {
                System.out.println("Course: " + row.getCourseTitle() + " | Enrolled: " + row.getEnrolledCount());
            }
            System.out.println("-|-----------|--------------------------------------|-----------|-");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}