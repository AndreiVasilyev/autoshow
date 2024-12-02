package by.clevertec.autoshow.entity;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;


@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Indexed
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Cacheable
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "text")
    @FullTextField
    private String text;

    @Column(name = "rate")
    @GenericField
    private Integer rate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @ToString.Exclude
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "car_id")
    @ToString.Exclude
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Car car;
}
