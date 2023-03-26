package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Catalog catalog = new Catalog("CATALOG");

        Document doc1 = new Document("1", "Primul Document", "document1.docx");
        doc1.addTag("autor", "Dascalu Rares");
        doc1.addTag("an", 2020);

        Document doc2 = new Document("2", "Al Doilea Document", "document2.docx");
        doc2.addTag("autor", "Marian Ciofu");
        doc2.addTag("an", 2023);

        catalog.add(doc1);
        catalog.add(doc2);

        CatalogUtil.save(catalog, "./catalog.json");

        Catalog loadedCatalog = CatalogUtil.load("./catalog.json");
        System.out.println(loadedCatalog);
    }
}
