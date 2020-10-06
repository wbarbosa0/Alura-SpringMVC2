INSERT INTO mudi.pedido (DATA_ENTREGA, DESCRICAO, NOME_PRODUTO, URL_IMAGEM_PRODUTO, URL_PRODUTO, VALOR_NEGOCIADO)
VALUES
(DATE(SYSDATE()), "Souza & Cia, 3349, Black Piano com Branco", 'Suporte de Monitor',
"https://images-na.ssl-images-amazon.com/images/I/61cfIQUyybL._AC_SL1500_.jpg",
"https://www.amazon.com.br/gp/product/B07D9SMPXJ?pf_rd_r=YHJM417RBRCDAWST4E8Y&pf_rd_p=72a7651a-a7d8-4551-b248-c61480b6ce6e",
71.50
);
COMMIT;