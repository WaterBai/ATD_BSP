package com.ssh.entity;

import freemarker.template.Template;

public class StatementTemplate {
    private SqlType type;
    private Template template;
    public StatementTemplate() {
    }
    public StatementTemplate(SqlType type, Template template) {
        super();
        this.type = type;
        this.template = template;
    }
    public SqlType getType() {
        return type;
    }
    public void setType(SqlType type) {
        this.type = type;
    }
    public Template getTemplate() {
        return template;
    }
    public void setTemplate(Template template) {
        this.template = template;
    }
}
