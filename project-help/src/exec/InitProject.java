package exec;

import model.Project;

//初始化Project

public class InitProject {
	private Project project = new Project();

	public InitProject(String name, String path, String webapp, String src) {
		project.setName(name);
		project.setPath(path);
		project.setWebapp(webapp);
		project.setSrc(src);
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
}
