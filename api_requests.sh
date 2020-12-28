usage() {
cat << EOF
  List of commands:
    (1) Help
    (2) Setup Database
    (3) Stop Database
    (4) Get Count
    (5) Get Names
EOF
}

performCurlGetRequest() {
  curl --request GET -sL --url $1
}

again="y"
commandOptions=("Help" "Setup Database" "Stop Database" "Get Count Less Than Age" "Get Names")

while [ $again == "y" ]
do
  echo "Select a command"
  select comOpt in "${commandOptions[@]}"
  do
    case "$comOpt" in
        "Help")
          usage
          break
        ;;
        "Get Count Less Than Age")
          echo What age would you like to search below?
          read age
          performCurlGetRequest "http://localhost:8080/getAgeLessThan?age=$age"
          echo ""
          break
        ;;
        "Get Names")
          performCurlGetRequest 'http://localhost:8080/getCount'
          echo ""
          break
        ;;
        "Setup Database")
          echo -e "A PostgreSQL server will now be attempted to start. To exit the postgres_playground DB, type exit. Press Enter to continue..."
          read irrelevant
          pg_ctl start
          break
        ;;
        "Stop Database")
          pg_ctl stop
          break
        ;;
    esac

  done

  echo Would you like to run again?
  read again

done
