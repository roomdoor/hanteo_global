package Problem1.main;

import Problem1.solution.domain.Category;
import Problem1.solution.repository.CategoryRepository;
import Problem1.solution.service.CategoryService;

public class Main {

	public static void main(String[] args) {

		CategoryService categoryService = new CategoryService(new CategoryRepository());

		Category man = categoryService.save(new Category("남자"));

		Category exo = categoryService.save(new Category("엑소"));
		Category notice = categoryService.save(new Category("공지사항"));
		Category ch = categoryService.save(new Category("첸"));
		Category bh = categoryService.save(new Category("백현"));
		Category xi = categoryService.save(new Category("시우민"));

		Category bts = categoryService.save(new Category("방탄소년단"));
		Category v = categoryService.save(new Category("뷔"));

		Category woman = categoryService.save(new Category("여자"));

		Category bp = categoryService.save(new Category("블랙핑크"));
		Category notice1 = categoryService.save(new Category("공지사항"));
		Category lo = categoryService.save(new Category("로제"));

		Category ab = categoryService.save(new Category("익명게시판"));

		man.addChild_idx(exo.getIndex());
		exo.addChild_idx(ch.getIndex());
		exo.addChild_idx(bh.getIndex());
		exo.addChild_idx(xi.getIndex());
		exo.addChild_idx(ab.getIndex());
		exo.addChild_idx(notice.getIndex());

		man.addChild_idx(bts.getIndex());
		bts.addChild_idx(v.getIndex());
		bts.addChild_idx(ab.getIndex());

		woman.addChild_idx(bp.getIndex());
		bp.addChild_idx(notice1.getIndex());
		bp.addChild_idx(lo.getIndex());
		bp.addChild_idx(ab.getIndex());

		categoryService.save(man);
		categoryService.save(exo);
		categoryService.save(bts);
		categoryService.save(woman);
		categoryService.save(bp);

		System.out.println(categoryService.getSubCategoryById(man.getIndex()));
		System.out.println();
		System.out.println(categoryService.getSubCategoryByName(man.getName()));
		System.out.println();
		System.out.println(categoryService.getSubCategoryById(ab.getIndex()));
		System.out.println();
		System.out.println(categoryService.getSubCategoryById(notice1.getIndex()));
		System.out.println();
		System.out.println(categoryService.getSubCategoryByName(woman.getName()));


	}

}
