package com.x.xgasto.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "pagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "gasto_id")
    @JsonIgnore
    private Gasto gasto;

    @Column(name = "data_vencimento")
    private Date vencimento;

    @Column(name = "data_pago")
    private Date pago;

    @Column(name = "valor_pago")
    private BigDecimal valorPago;


}
