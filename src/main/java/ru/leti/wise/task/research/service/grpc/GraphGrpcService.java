package ru.leti.wise.task.research.service.grpc;

import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.leti.wise.task.graph.GraphGrpc.GenerateGraphRequest;
import ru.leti.wise.task.graph.GraphOuterClass.Graph;


@Component
@Observed
@RequiredArgsConstructor
public class GraphGrpcService {

    private final GraphStubHolder graphStubHolder;

    public Graph getGraph(int edgeCount, int vertexCount, boolean isDirect) {
        var request = GenerateGraphRequest.newBuilder()
                .setEdgeCount(edgeCount)
                .setVertexCount(vertexCount)
                .setIsDirect(isDirect)
                .setIsSaved(true)
                .build();

        return graphStubHolder.get().generateRandomGraph(request).getGraph();
    }
}
