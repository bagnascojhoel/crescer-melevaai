import './styles.css';
import React from 'react';

export function DataList({ dataList, itemComponent, keyExtractor, ...props }) {
  return (
    <ul className="data-list">
      {dataList.length > 0 ? (
        dataList.map((data) => (
          <li className="data-list-item" key={keyExtractor(data)}>
            {React.createElement(itemComponent, { data, ...props })}
          </li>
        ))
      ) : (
        <li className="data-list-item">
          <h3 className="data-list-item__text">Nenhum item na lista</h3>
        </li>
      )}
    </ul>
  );
}

DataList.defaultProps = {
  dataList: [],
  keyExtractor: () => {},
};
