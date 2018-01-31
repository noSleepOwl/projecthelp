package exec;

import model.Project;

//初始化Project

public class InitProject {
	private Project project = new Project();

	/**
	 * 测试分支用的注释...
	 * 
	 * @param name
	 * @param path
	 * @param webapp
	 * @param src
	 */
	public InitProject(String name, String path, String webapp, String src) {
		project.setName(name);
		project.setPath(path);
		project.setWebapp(webapp);
		project.setSrc(src);
	}

	/**
	 * 这是主要的分支 , 在这里用的是什么? 无用的东西 , 分支在这里使用
	 * 
	 * @return
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * 测试分支_2 测试用的 ...
	 * 
	 * @param project
	 */
	public void setProject(Project project) {
		this.project = project;
	}
	
}
