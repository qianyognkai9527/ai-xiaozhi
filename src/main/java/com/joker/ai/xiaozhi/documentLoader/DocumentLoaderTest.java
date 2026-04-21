package com.joker.ai.xiaozhi.documentLoader;


import com.joker.ai.xiaozhi.App;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.parser.TextDocumentParser;
import dev.langchain4j.data.document.parser.apache.pdfbox.ApachePdfBoxDocumentParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.util.List;

@SpringBootTest(classes = App.class)
public class DocumentLoaderTest {

    @Test
    public void test1() {
        //使用FileSystemDocumentLoader读取指定目录下的知识库文档
        //并使用默认的文档解析器TextDocumentParser对文档进行解析
        Document document = FileSystemDocumentLoader.loadDocument("/Users/qyk9527/ideaProject/ai-xiaozhi/src/main/resources/knowledge/测试.txt");
        System.out.println(document.metadata());
        System.out.println(document.text());

    }

    @Test
    public void test2() {
        //加载单个文件

        Document document1 = FileSystemDocumentLoader.
                loadDocument("/Users/qyk9527/ideaProject/ai-xiaozhi/src/main/resources/knowledge/测试.txt",
                        new TextDocumentParser());
        System.out.println(document1.metadata());
        System.out.println(document1.text());
    }

    @Test
    public void test3() {
        //从一个目录中 加载多个文件
        List<Document> documents =
                FileSystemDocumentLoader.loadDocuments("/Users/qyk9527/ideaProject/ai-xiaozhi/src/main/resources/knowledge", new TextDocumentParser());
        documents.stream().forEach(document -> {
            System.out.println(document.text());
            System.out.println("================================================>");
        });

    }

    @Test
    public void test4() {

        //从一个目录中 加载匹配到的文件
//        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:*.md");
        List<Document> documents = FileSystemDocumentLoader.loadDocuments("/Users/qyk9527/ideaProject/ai-xiaozhi/src/main/resources/knowledge", pathMatcher, new TextDocumentParser());
        documents.stream().forEach(document -> {
            System.out.println(document.metadata());
            System.out.println(document.text());
            System.out.println("================================================>");
        });
    }

    @Test
    public void test5() {

        // 从一个目录及其子目录中加载所有文档
        List<Document> documents =
                FileSystemDocumentLoader.loadDocumentsRecursively("/Users/qyk9527/ideaProject/ai-xiaozhi/src/main/resources/knowledge", new
                        TextDocumentParser());
        documents.stream().forEach(document -> {
            System.out.println("================================================>");
            System.out.println(document.metadata());
            System.out.println(document.text());
        });
    }

    @Test
    public void test6() {
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:*.pdf");
        List<Document> documents =
                FileSystemDocumentLoader.loadDocuments("/Users/qyk9527/ideaProject/ai-xiaozhi/src/main/resources/knowledge",pathMatcher,
                         new ApachePdfBoxDocumentParser());
        documents.stream().forEach(document -> {
            System.out.println("================================================>");
            System.out.println(document.metadata());
            System.out.println(document.text());
        });
    }

}
