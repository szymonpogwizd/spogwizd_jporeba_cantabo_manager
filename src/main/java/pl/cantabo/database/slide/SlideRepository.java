package pl.cantabo.database.slide;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SlideRepository extends JpaRepository<SlideDAO> {
}
