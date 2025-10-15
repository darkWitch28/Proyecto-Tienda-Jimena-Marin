package techtienda.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;
    private Long idCategoria;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "La descripción no puede estar vacía.")
    @Size(max = 50, message = "La descripción no puede tener más de 50 caracteres.")
    private String descripcion;

    @Column(columnDefinition = "TEXT")
    private String detalle;

    @Column(precision = 12, scale = 2)
    @NotNull(message = "El precio no puede estar vacío.")
    @DecimalMin(value = "0.01", inclusive = true, message = "El precio debe ser mayor a 0.")
    private BigDecimal precio;

    @NotNull(message = "El campo de existencias no puede estar vacío.")
    @Min(value = 0, message = "Las existencias deben ser un número mayor o igual a 0.")
    private Long existencias;

    @Column(name = "ruta_imagen", length = 1024)
    private String rutaImagen;
    private boolean activo;
    
    @ManyToOne
    @JoinColumn(name = "idCtegoria")
    private Categoria categoria;
}
