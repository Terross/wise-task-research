package ru.leti.wise.task.research.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.leti.wise.task.research.mapper.GraphMapper;
import ru.leti.wise.task.research.plugins.VertexCount;
import ru.leti.wise.task.research.service.grpc.GraphGrpcService;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final GraphGrpcService graphGrpcService;
    private final VertexCount vertexCountPlugin;
    private final GraphMapper graphMapper;

    @GetMapping("/test")
    public void test() {
        var response = graphGrpcService.getGraph(5, 10, false);
        var graph = graphMapper.toGraph(response);
        int vertexCount = vertexCountPlugin.run(graph);
        System.out.println(vertexCount);
    }
}
