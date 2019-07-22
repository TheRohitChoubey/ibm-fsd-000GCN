const projects = require('../db/projects').projects;
class ProjectService {
    projects = [];
    constructor() {
        this.projects = projects;
    }
    _all() {
        return this.projects;
    }
    _add(project) {
        this.projects.push(project);
        return this.projects;
    }

    _nextId() {
        return this.projects.length + 1;
    }
}

module.exports.ProjectService = ProjectService;