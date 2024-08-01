    package ecommerce.entity;

    import com.fasterxml.jackson.annotation.JsonIgnore;
    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.util.List;

    @Data
    @Entity
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name = "products",schema = "e_commerce")
    public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        private String description;

        private Double price;

        private Integer stock;

        @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
        @JoinColumn(name="category_id")
        private Category category;

        @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
        private List<ProductImages> productImages;

    }
