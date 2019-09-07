FROM microsoft/dotnet:2.1-aspnetcore-runtime AS base
WORKDIR /app
EXPOSE 80
EXPOSE 443

FROM microsoft/dotnet:2.1-sdk AS build
WORKDIR /src
COPY ["HiveDataCollector/HiveDataCollector.csproj", "HiveDataCollector/"]
RUN dotnet restore "HiveDataCollector/HiveDataCollector.csproj"
COPY . .
WORKDIR "/src/HiveDataCollector"
RUN dotnet build "HiveDataCollector.csproj" -c Release -o /app

FROM build AS publish
RUN dotnet publish "HiveDataCollector.csproj" -c Release -o /app

FROM base AS final
WORKDIR /app
COPY --from=publish /app .
ENTRYPOINT ["dotnet", "HiveDataCollector.dll"]