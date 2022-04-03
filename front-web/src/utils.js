export function transformDate(unformattedDate) {
  const date = unformattedDate.split('-');

  return `${date[2]}/${date[1]}/${date[0]}`;
}

export function formatCPF(uCPF) {
  const part1 = uCPF.substring(0, 3);
  const part2 = uCPF.substring(3, 6);
  const part3 = uCPF.substring(6, 9);
  const part4 = uCPF.substring(9, 11);

  return `${part1}.${part2}.${part3}-${part4}`;
}

export function mapToOption(value) {
  return {
    text: value,
    value,
  };
}

export function formatMoneyAsBRL(value) {
  const formatter = new Intl.NumberFormat('pt-BR', {
    style: 'currency',
    currency: 'BRL',
  });
  return formatter.format(value);
}
