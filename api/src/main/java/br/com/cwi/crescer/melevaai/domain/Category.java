package br.com.cwi.crescer.melevaai.domain;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public enum Category {

    A("Todos os veículos automotores e elétricos, de duas ou três rodas, com ou sem carro lateral."),
    B("Veículos automotores e elétricos, de quatro rodas cujo peso bruto total não exceda a três mil e quinhentos quilogramas e cuja lotação não exceda a 08 (oito) lugares."),
    C("Todos os veículos automotores e elétricos utilizados em transporte de carga, cujo peso bruto total exceda a três mil e quinhentos quilogramas."),
    D("Veículos automotores e elétricos utilizados no transporte de passageiros, cuja lotação exceda a 08 (oito) lugares e, todos os veículos abrangidos nas categorias."),
    E("Combinação de veículos em que a unidade tratora se enquadre nas categorias B, C ou D e cuja unidade acoplada, reboque, semirreboque, trailer ou articulada tenha 6.000 kg (seis mil quilogramas) ou mais de peso bruto total, ou cuja lotação exceda a 8 (oito) lugares e, todos os veículos abrangidos pelas categorias B, C e D."),
    ACC("Veículos de duas ou três rodas, providos de um motor de combustão interna, cuja cilindrada não exceda a cinquenta centímetros cúbicos (3,05 polegadas cúbicas) e cuja velocidade máxima de fabricação não exceda a cinquenta quilômetros por hora.");

    private final String description;
}
