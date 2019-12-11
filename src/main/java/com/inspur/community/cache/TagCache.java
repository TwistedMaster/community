package com.inspur.community.cache;

import com.inspur.community.dto.TagDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TagCache {
    public static List<TagDTO> get() {
        List<TagDTO> tagDTOS = new ArrayList<>();
        TagDTO program = new TagDTO();
        program.setCategoryName("开发语言");
        program.setTags(Arrays.asList("php", "java", "node.js", "python", "c++", "c", "golang", "spring", "django", "flask", "springboot", "后端", "c#", "swoole", "ruby", "asp.net", "ruby-on-rails", "scala", "rust", "lavarel", "爬虫", "javascript", "前端", "vue.js", "html5", "css3", "angular"));
        tagDTOS.add(program);

        TagDTO framework = new TagDTO();
        framework.setCategoryName("平台框架");
        framework.setTags(Arrays.asList("laravel", "spring", "express", "django", "flask", "yii", "ruby-on-rails", "tornado", "koa", "struts"));
        tagDTOS.add(framework);

        TagDTO server = new TagDTO();
        server.setCategoryName("服务器");
        server.setTags(Arrays.asList("linux", "nginx", "docker", "apache", "centos", "ubuntu", "服务器", "负载均衡", "运维", "ssh", "vagrant", "容器", "jenkins", "devops", "debian", "fabric"));
        tagDTOS.add(server);

        TagDTO db = new TagDTO();
        db.setCategoryName("数据库");
        db.setTags(Arrays.asList("mysql", "redis", "mongodb", "sql", "数据库", "json", "elasticsearch", "nosql", "memcached", "postgresql", "sqlite", "mariadb"));
        tagDTOS.add(db);

        TagDTO tool = new TagDTO();
        tool.setCategoryName("开发工具");
        tool.setTags(Arrays.asList("git", "github", "macos", "visual-studio-code", "windows", "vim", "sublime-text", "intellij-idea", "eclipse", "phpstorm", "webstorm", "编辑器", "svn", "visual-studio", "pycharm", "emacs"));
        tagDTOS.add(tool);
        return tagDTOS;
    }

    public static String filterInvalid(String tags) {
        String[] split = StringUtils.split(tags, ",");
        List<TagDTO> tagDTOS = get();
        List<String> tagList = tagDTOS.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
        String invalid = Arrays.stream(split).filter(t -> !tagList.contains(t)).collect(Collectors.joining(","));
        return invalid;
    }
}
