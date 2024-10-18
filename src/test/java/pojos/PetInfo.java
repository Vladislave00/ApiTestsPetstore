package pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class PetInfo {
    private Long id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;

    // Конструктор по умолчанию
    public PetInfo() {
        this.id = 0L; // Инициализация нулем
        this.category = new Category(); // Инициализация null
        this.name = ""; // Инициализация пустой строкой
        this.photoUrls = new ArrayList<>(); // Инициализация пустым списком
        this.tags = new ArrayList<Tag>(); // Инициализация пустым списком
        this.status = ""; // Инициализация пустой строкой
    }

    // Конструктор с параметрами
    @JsonCreator
    public PetInfo(@JsonProperty("id") long id,
                   @JsonProperty("category") Category category,
                   @JsonProperty("name") String name,
                   @JsonProperty("photoUrls") List<String> photoUrls,
                   @JsonProperty("tags") List<Tag> tags,
                   @JsonProperty("status") String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    // Геттеры и сеттеры
    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Вложенные классы Category и Tag
    public static class Category {
        private long id;
        private String name;

        public Category() {
            this.id = 0; // Инициализация нулем
            this.name = ""; // Инициализация пустой строкой
        }

        @JsonCreator
        public Category(@JsonProperty("id") long id, @JsonProperty("name") String name) {
            this.id = id;
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Tag {
        private long id;
        private String name;

        public Tag() {
            this.id = 0;
            this.name = "";
        }

        @JsonCreator
        public Tag(@JsonProperty("id") long id, @JsonProperty("name") String name) {
            this.id = id;
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
