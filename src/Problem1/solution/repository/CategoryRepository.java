package Problem1.solution.repository;

import Problem1.solution.db.MemoryDbRepositoryAbstract;
import Problem1.solution.domain.Category;
import java.util.Optional;

public class CategoryRepository extends MemoryDbRepositoryAbstract<Category> {

	public Optional<Category> findByName(String name) {
		return this.findAll().stream().filter(c -> c.getName().equals(name)).findFirst();
	}
}
